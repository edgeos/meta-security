SUMMARY = " \
  The TPM Quote Tools is a collection of programs that provide support \
  for TPM based attestation using the TPM quote mechanism. \
  "
DESCRIPTION = " \
  The TPM Quote Tools is a collection of programs that provide support \
  for TPM based attestation using the TPM quote mechanism.  The manual \
  page for tpm_quote_tools provides a usage overview. \
  \
  TPM Quote Tools has been tested with TrouSerS on Linux and NTRU on \
  Windows XP.  It was ported to Windows using MinGW and MSYS. \
  "

PR = "r0"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD;md5=3775480a712fc46a69647678acb234cb"
DEPENDS = "libtspi tpm-tools"

SRCREV = "5025a6aaea13a530d4d7c14d9040109e55919ce3"
SRC_URI = " \
        git://github.build.ge.com/PredixEdgeProjects/tpm-quote-tools.git;branch=master;protocol=https \
"
S = "${WORKDIR}/git"

inherit autotools
