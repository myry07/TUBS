cmake_minimum_required(VERSION 3.27)
project(qianfengEdu C)

set(CMAKE_C_STANDARD 11)

add_library(qianfengEdu STATIC library.c
        Chapter2_Basic/hello.c
        Chapter2_Basic/char_.c
        Chapter2_Basic/sizeof_.c
        Chapter2_Basic/void_.c
        Chapter2_Basic/typedef_.c
        Chapter3_Datentype/primitiveDaten.c
        Chapter3_Datentype/automatConve.c
        Chapter3_Datentype/operation.c
        Chapter3_Datentype/loop_.c
        Chapter3_Datentype/goto_.c
        Chapter3_Datentype/flowerNumber.c
        Chapter6_inc&def/include_.c
        Chapter6_inc&def/define_.c
        Chapter6_inc&def/ifdef_.c
        Chapter7_Point/def.c
        Chapter7_Point/point&variable.c
        Chapter7_Point/point&variable.c
        Chapter7_Point/point&array.c
        Chapter7_Point/operationOfPiont.c
        Chapter7_Point/pointArray.c
        Chapter7_Point/pointPoint.c
        Chapter7_Point/string&point.c
        Chapter7_Point/arraryPoint.c
        Chapter7_Point/functionPoint.c
        Chapter7_Point/mainWithPara.c
        Chapter8_DynamicMemory/dynamicAllocation.c
        Chapter8_DynamicMemory/malloc_.c
        Chapter8_DynamicMemory/calloc_.c
        Chapter8_DynamicMemory/realloc.c
        Chapter9_StringMani/strlen.c
        Chapter9_StringMani/strcpy.c
        Chapter9_StringMani/strcpy.c
        Chapter9_StringMani/strcpy.c
        Chapter9_StringMani/strcpy.c
        Chapter9_StringMani/strncpy.c
        Chapter9_StringMani/strcat.c
        Chapter9_StringMani/strncat.c
        Chapter9_StringMani/strcmp.c
        Chapter9_StringMani/strncmp.c
        Chapter9_StringMani/strchr.c
        Chapter9_StringMani/strstr.c
        Chapter9_StringMani/memset.c
        Chapter9_StringMani/convert.c
        Chapter9_StringMani/strtok.c
        Chapter9_StringMani/const.c
        Chapter10_Structure/definition.c
        Chapter10_Structure/init.c
        Chapter10_Structure/structArray.c
        Chapter10_Structure/structPiont.c
        Chapter10_Structure/situation.c
        Chapter10_Structure/union.c
        Chapter10_Structure/enum.c
        Chapter11_Document/docPiont.c
        Chapter11_Document/fopen_fclose.c
        Chapter11_Document/fgetc_fputc.c
        Chapter11_Document/fread_fwrite.c)
