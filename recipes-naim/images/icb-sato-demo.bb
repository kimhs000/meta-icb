# Basically core-image-sato-dev + extra packages in IMAGE_INSTALL below

DESCRIPTION = "Image with Sato, a mobile environment and visual style for \
mobile devices. The image supports X11 with a Sato theme, Pimlico \
applications, and contains terminal, editor, and file manager."

IMAGE_FEATURES += "splash package-management x11-base x11-sato ssh-server-dropbear hwcodecs"

LICENSE = "MIT"

inherit core-image

TOOLCHAIN_HOST_TASK_append = " nativesdk-intltool nativesdk-glib-2.0"
TOOLCHAIN_HOST_TASK_remove_task-populate-sdk-ext = " nativesdk-intltool nativesdk-glib-2.0"

QB_MEM = '${@bb.utils.contains("DISTRO_FEATURES", "opengl", "-m 512", "-m 256", d)}'
QB_MEM_qemumips = "-m 256"

CORE_IMAGE_BASE_INSTALL += "\
	nodejs \
	packagegroup-fsl-gstreamer1.0-full \
	tslib-tests tslib-calibrate \
	flex \
	gcc \
	git \
	m4 \
	make \
	iperf3 \
	libtool \
	nano \
	python-compiler \
	strace \
	screen \
	minicom \
	openssl \
	cryptodev-module \
"
