require recipes-bsp/u-boot/u-boot.inc
inherit fsl-u-boot-localversion

SUMMARY = "U-Boot bootloader with support for ICB board"
DESCRIPTION = "U-Boot bootloader with support for ICB board."

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=30503fd321432fc713238f582193b78e"

COMPATIBLE_MACHINE = "(mxs|mx5|mx6|mx7|vf|imx6q-icb)"

PROVIDES += "u-boot"

PV = "v2019.07+git${SRCPV}"

SRCBRANCH = "u-boot-icb-v2019.07"
SRC_URI = "git://github.com/kimhs000/u-boot-icb.git;branch=${SRCBRANCH}"
SRCREV = "aa408370c9c84c756ea2a148cc57576f6f07cb39"

S = "${WORKDIR}/git"

DEPENDS += "bison-native"
DEPENDS_append = " bc-native dtc-native"

# FIXME: Allow linking of 'tools' binaries with native libraries
#        used for generating the boot logo and other tools used
#        during the build process.
EXTRA_OEMAKE += 'HOSTCC="${BUILD_CC} ${BUILD_CPPFLAGS}" \
                 HOSTLDFLAGS="${BUILD_LDFLAGS}" \
                 HOSTSTRIP=true'

PACKAGE_ARCH = "${MACHINE_ARCH}"

