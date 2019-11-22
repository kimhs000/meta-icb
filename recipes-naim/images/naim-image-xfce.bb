DESCRIPTION = "ICB XFCE desktop demo image."

IMAGE_FEATURES += "splash package-management ssh-server-dropbear hwcodecs dev-pkgs"

LICENSE = "MIT"

inherit core-image distro_features_check

REQUIRED_DISTRO_FEATURES = "x11"

CORE_IMAGE_BASE_INSTALL += "\
	packagegroup-core-boot \
	packagegroup-core-x11 \
	packagegroup-xfce-base \
	kernel-modules \
	\
	nodejs \
	packagegroup-fsl-gstreamer1.0-full \
	\
	flex \
	gcc \
	git \
	m4 \
	make \
	iperf2 \
	libtool \
	nano \
	python-compiler \
	strace \
	screen \
	minicom \
	openssl \
	cryptodev-module \
"

IMAGE_LINGUAS ?= " "

export IMAGE_BASENAME = "naim-image-xfce"
