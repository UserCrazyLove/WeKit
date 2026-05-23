package dev.ujhhgtg.wekit.utils.reflection

import org.luckypray.dexkit.result.ClassData
import org.luckypray.dexkit.result.MethodData

inline val MethodData.asMethod get() = getMethodInstance(ClassLoaders.HOST)

inline val ClassData.asClass get() = getInstance(ClassLoaders.HOST)
