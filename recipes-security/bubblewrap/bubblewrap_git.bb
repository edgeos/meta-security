DESCRIPTION = "Helper binary for running applications sandboxed."
HOMEPAGE = "https://github.com/projectatomic/bubblewrap"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=5f30f0716dfdd0d91eb439ebec522ec2"

DEPENDS = "libcap"

SRC_URI = " \
    git://git@github.com/projectatomic/bubblewrap;protocol=https \
"
SRCREV = "3ebe54af1b2acb702381ec9b5610b60758d3d163"

PV = "2016.8+git${SRCPV}"
S = "${WORKDIR}/git"

inherit autotools pkgconfig
require conf/distro/include/security_flags.inc

AUTO_LIBNAME_PKGS = ""

# possible package configurations
PACKAGECONFIG ??= ""

EXTRA_OECONF_class-target += "--disable-man --without-bash-completion-dir"
EXTRA_OECONF_class-native += "--disable-man --without-bash-completion-dir"

BBCLASSEXTEND = "native"

do_configure() {
	cd ${S}
	NOCONFIGURE=1 ./autogen.sh
	./configure --host=${HOST_SYS} ${EXTRA_OECONF_class-target}
}

do_compile_prepend() {
	cd ${S}
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/bwrap ${D}${bindir}
	# set suid
	chmod u+s ${D}${bindir}/bwrap
}
