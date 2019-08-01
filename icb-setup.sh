#!/bin/sh
 
LAYERS_DIR=./sources/base/conf/
LAYER_ICB_STRING="BBLAYERS += \"\${BSPDIR}/sources/meta-icb\""
 
if [ -w ${LAYERS_DIR}/bblayers.conf ]
then
    grep "${LAYER_ICB_STRING}" "${LAYERS_DIR}/bblayers.conf" > /dev/null
    TMPRETVAL=$(echo $?)
    TMPPRINT=""
 
    if [ ${TMPRETVAL} -eq 0 ]
    then
        TMPPRINT="already present"
    fi
 
    if [ ${TMPRETVAL} -eq 1 ]
    then
        echo "${LAYER_ICB_STRING}" >> ${LAYERS_DIR}/bblayers.conf
        TMPPRINT="added"
    fi
 
    echo "Layer meta-icb ${TMPPRINT}"
fi
