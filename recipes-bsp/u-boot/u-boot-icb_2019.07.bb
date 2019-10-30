require recipes-bsp/u-boot/u-boot.inc
inherit fsl-u-boot-localversion

SUMMARY = "U-Boot bootloader with support for ICB board"
DESCRIPTION = "U-Boot bootloader with support for ICB board."

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=30503fd321432fc713238f582193b78e"

COMPATIBLE_MACHINE = "(mxs|mx5|mx6|mx7|vf|imx6q-icb)"

PROVIDES += "u-boot"

PV = "v2019.07+git${SRCPV}"

SRCBRANCH = "pyro_191021"
SRC_URI = "git://github.com/kimhs000/icb-uboot-v2019.07.git;branch=${SRCBRANCH}"
SRCREV = "83494b9b57d22e16070a9f76eb0303f56682e24b"

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

