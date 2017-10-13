SUMMARY = "LIBPM - Software TPM Library"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=97e5eea8d700d76b3ddfd35c4c96485f"
SRCREV = "9649f4b866ea8c3c4c778d80d6751b1116be7a90"
SRC_URI = "git://github.com/stefanberger/libtpms.git"

S = "${WORKDIR}/git"
inherit autotools-brokensep pkgconfig

PACKAGECONFIG ?= "openssl"
PACKAGECONFIG[openssl] = "--with-openssl, --without-openssl, openssl"

PV = "1.0+git${SRCPV}"

BBCLASSEXTEND = "native"
