# Simple recipe to add desktop icon and executable to run gstreamer
# command to display video input on screen in media player.

DESCRIPTION = "Video Input Desktop Icon/Executable"
LICENSE = "CLOSED"
# LIC_FILES_CHKSUM = "file://COPYING;md5=94daa384fc5c25bfd601053422b44233"

PR = "r0"

SRC_URI = " \
	file://IR-Camera-Test.desktop \
	file://ircamera-test \
"

S = "${WORKDIR}"

do_install_imx6q-icb() {
	mkdir -p ${D}/usr/bin/
	mkdir -p ${D}/usr/share/applications/
	cp ${S}/IR-Camera-Test.desktop ${D}/usr/share/applications/
	cp ${S}/ircamera-test ${D}/usr/bin/
}

FILES_${PN}_imx6q-icb = " \
	/usr/bin/* \
	/usr/share/applications/* \
"
