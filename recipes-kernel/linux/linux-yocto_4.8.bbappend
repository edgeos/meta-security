FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-4.8:"

# TPM kernel support
SRC_URI += "\
        ${@bb.utils.contains('DISTRO_FEATURES', 'tpm', ' file://tpm.cfg', '', d)} \
        ${@bb.utils.contains('DISTRO_FEATURES', 'tpm', ' file://tpm.scc', '', d)} \
"

SRC_URI += "\
        ${@bb.utils.contains('DISTRO_FEATURES', 'smack', ' file://smack.cfg', '', d)} \
        ${@bb.utils.contains('DISTRO_FEATURES', 'smack', ' file://smack-default-lsm.cfg', '', d)} \
"

SRC_URI += "\
	${@bb.utils.contains('DISTRO_FEATURES', 'apparmor', ' file://apparmor.cfg', '', d)} \
"

SRC_URI += "\
	${@bb.utils.contains('DISTRO_FEATURES', 'seccomp', ' file://seccomp.cfg', '', d)} \
"

# Hardening
SRC_URI += "\
	file://restrict_devmem.cfg \
	file://randomize_kernel_heap.cfg \
	file://stackprotector.cfg \
	file://hardened_usercopy.cfg \
	file://readonly_kernel.cfg \
"
