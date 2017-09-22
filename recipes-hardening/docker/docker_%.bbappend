FILESEXTRAPATHS_append := "${THISDIR}/${PN}:"

DEPENDS += " \
  libseccomp \
  "

CFLAGS += " \
  -fstack-protector-strong \
  -Wformat \
  -Wformat-security \
  -Werror=format-security \
  "

LDFLAGS += " \
  -fstack-protector-strong \
  -Wl,-z,relro,-z,now \
  "

SRC_URI += " \
  file://hack-make-seccomp-buildtags.patch \
  "
