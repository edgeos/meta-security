SUMMARY = "Check security properties of executables"
DESCRIPTION = "Checksec is a bash script to check the properties of executables (like PIE, RELRO, PaX, Canaries, ASLR, Fortify Source)."
SECTION = "security"
LICENSE = "BSD"
HOMEPAGE = "https://github.com/slimm609/checksec.sh"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=93fddcca19f6c897871f9b5f9a035f4a"

DEPENDS = "binutils file"

SRCREV = "3de323ec3166252c8a4ec3c7fa14003e815902a6"

SRC_URI = "\
	git://github.com/slimm609/checksec.sh.git \
	file://busybox-sysctl.patch \
	file://usercopy_whitespace_fix.patch \
	"

S = "${WORKDIR}/git"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/checksec    ${D}${bindir}
}

RDEPENDS_${PN} = "bash"
