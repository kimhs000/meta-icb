# meta-icb
Naimtechnology Yocto Project for ICB

# Essentials: Packages needed to build an image on a headless system

### 1) Install the packages
    sudo apt-get install gawk wget git-core diffstat unzip texinfo gcc-multilib \
    build-essential chrpath socat cpio python python3 python3-pip python3-pexpect \
    xz-utils debianutils iputils-ping python3-git python3-jinja2 libegl1-mesa libsdl1.2-dev \
    xterm

    sudo apt-get install curl
    sudo apt-get install bison

# How to compile & use software for ICB 
 
Here you will find some basic info about how to start with YOCTO and ICB. If you follow the steps below, you should be able to compile the source code. 
 
 
### 1) Install the repo utility
    mkdir ~/bin
    curl http://commondatastorage.googleapis.com/git-repo-downloads/repo > ~/bin/repo
    chmod a+x ~/bin/repo
 
### 2) Get the YOCTO project
    cd
    mkdir fsl-community-bsp
    cd fsl-community-bsp
    PATH=${PATH}:~/bin
    repo init -u https://github.com/Freescale/fsl-community-bsp-platform -b warrior
 
### 3) Add icb support - create manifest 
    cd ~/fsl-community-bsp/
    mkdir -pv .repo/local_manifests/
 
Copy and paste this into your Linux host machine 
 
    cat > .repo/local_manifests/imx6icb.xml << EOF
    <?xml version="1.0" encoding="UTF-8"?>
    <manifest>
     
      <remote fetch="git://github.com/kimhs000" name="kimhs000"/>
     
      <project remote="kimhs000" revision="icb_v20190801" name="meta-icb" path="sources/meta-icb">
        <copyfile src="icb-setup.sh" dest="icb-setup.sh"/>
      </project>
    </manifest>
    EOF
 
### 4) Sync repositories
    repo sync
 
### 5) Add OpenRex meta layer into BSP
    source icb-setup.sh
 
# Building images
    cd ~/fsl-community-bsp/
 
### Currently Supported machines <machine name>
Here is a list of 'machine names' which you can use to build ICB images. Use the 'machine name' based on the board you have:
 
 
    imx6q-icb
     
### Setup and Build Console image
    MACHINE=<machine name> DISTRO=<distro name> source setup-environment build-icb
    bitbake core-image-base
 
Example:
 
 
    MACHINE=imx6q-icb DISTRO=fslc-x11 source setup-environment build-icb
    bitbake core-image-base
 
### Setup and Build Toolchain    
    MACHINE=<machine name> bitbake core-image-base -c populate_sdk
     
### Setup and Build FSL GUI image
    MACHINE=<machine name> source fsl-setup-release.sh -b build-x11 -e x11
    MACHINE=<machine name> bitbake fsl-image-gui
 
# Creating SD card
Output directories and file names depend on what you build. Following example is based on running 'bitbake core-image-base':
 
 
    umount /dev/sdb?
    sudo bmaptool copy --nobmap tmp/deploy/images/imx6qdlicb/core-image-base-imx6qdlicb.wic.gz /dev/sdb

     
# Testing it on icb (initial uBoot runs from SPI)
To test your uBoot on SD card, plug in the card which you have just created into an icb board. Reset the icb board (press "Reset" button), interrupt the uBoot countdown (press "Spacebar" or the "Enter" key) and run following command:
 
    mw.l 0x020d8040 0x2840; mw.l 0x020d8044 0x10000000; reset
 
# Updating icb
TO
