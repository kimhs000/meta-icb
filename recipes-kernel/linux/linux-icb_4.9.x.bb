# Copyright (C) 2019 Naimtechnology
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Linux Kernel for ICB board"
DESCRIPTION = "Linux kernel for ICB board"

#PV .= "+git${SRCPV}"
# PV .= ""
PV_append = "+git${SRCPV}"

require recipes-kernel/linux/linux-imx.inc

DEPENDS += "lzop-native bc-native"

SRC_URI = "git://github.com/kimhs000/icb-linux-4.9.git;branch=${SRCBRANCH} \
           file://defconfig"

LOCALVERSION = "-0.0.1"

SRCBRANCH = "4.9-1.0.x-mx6icb"
SRCREV = "ef8c3358bafe6643cfedb8ca54075e3a6950ab16"

COMPATIBLE_MACHINE = "(imx6q-icb)"
