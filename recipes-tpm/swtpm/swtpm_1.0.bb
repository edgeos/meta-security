SUMMARY = "SWTPM - Software TPM Emulator"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fe8092c832b71ef20dfe4c6d3decb3a8"
SECTION = "apps"

DEPENDS = "libtasn1 fuse expect expect-native socat glib-2.0 libtpm libtpm-native tpm-tools-native"

SRCREV = "66250d635a2e91a87403d50bc868da471a1e1bbb"
SRC_URI = "git://github.com/stefanberger/swtpm.git \
           ${@bb.utils.contains('TARGET_ARCH','arm','file://arm_werror_config.patch','',d)} \
          "

S = "${WORKDIR}/git"

inherit autotools-brokensep pkgconfig
PARALLEL_MAKE = ""

TSS_USER="tss"
TSS_GROUP="tss"

PACKAGECONFIG ?= "openssl"
PACKAGECONFIG += "${@bb.utils.contains('DISTRO_FEATURES', 'selinux', 'selinux', '', d)}"
PACKAGECONFIG[openssl] = "--with-openssl, --without-openssl, openssl"
PACKAGECONFIG[gnutls] = "--with-gnutls, --without-gnutls, gnutls"
PACKAGECONFIG[selinux] = "--with-selinux, --without-selinux, libselinux"

EXTRA_OECONF += "--with-tss-user=${TSS_USER} --with-tss-group=${TSS_GROUP}"

export LIBRARY_PATH = "${STAGING_LIBDIR_NATIVE}"

USERADD_PACKAGES = "${PN}"
GROUPADD_PARAM_${PN} = "--system ${TSS_USER}"
USERADD_PARAM_${PN} = "--system -g ${TSS_GROUP} --home-dir  \
    --no-create-home  --shell /bin/false ${BPN}"

RDEPENDS_${PN} = "libtpm expect socat bash"
