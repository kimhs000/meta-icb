# Copyright (C) 2019 Naimtechnology
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Linux Kernel for ICB board"
DESCRIPTION = "Linux kernel for ICB board"

# require recipes-kernel/linux/linux-imx.inc

DEPENDS += "lzop-native bc-native"

#PV .= "+git${SRCPV}"
PV .= ""

#SRCBRANCH = "4.9-1.0.x-mx6icb"
SRCBRANCH = "linux4.9_191022"
LOCALVERSION = "-0.0.1"

SRCREV = "3a86e6a616eb4242600a922978f179bdb9410d61"
SRC_URI = "git://github.com/kimhs000/icb-linux-4.9.git;branch=${SRCBRANCH} \
           file://defconfig"

COMPATIBLE_MACHINE = "(mx6|imx6q-icb)"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel fsl-kernel-localversion fsl-vivante-kernel-driver-handler

S = "${WORKDIR}/git"

# We need to pass it as param since kernel might support more then one
# machine, with different entry points
KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"
