# Copyright (C) 2019 Naimtechnology
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Linux Kernel for ICB board"
DESCRIPTION = "Linux kernel for ICB board"

PV .= "+git${SRCPV}"

require recipes-kernel/linux/linux-imx.inc

DEPENDS += "lzop-native bc-native"

SRC_URI = "git://github.com/kimhs000/icb-linux-4.9;branch=${SRCBRANCH} \
           file://defconfig"
LOCALVERSION = "-fslc"

SRCBRANCH = "4.9-1.0.x-mx6icb"
SRCREV = "ef8c3358bafe6643cfedb8ca54075e3a6950ab16"

COMPATIBLE_MACHINE = "(mx6|mx7|imx6q-icb)"
