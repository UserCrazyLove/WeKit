package dev.ujhhgtg.wekit.hooks.items.miniapps

import dev.ujhhgtg.wekit.dexkit.abc.IResolvesDex
import dev.ujhhgtg.wekit.dexkit.dsl.dexMethod
import dev.ujhhgtg.wekit.hooks.core.HookItem
import dev.ujhhgtg.wekit.hooks.core.SwitchHookItem
import org.luckypray.dexkit.DexKitBridge

@HookItem(path = "小程序/伪装宿主版本", description = "解决提示版本较低无法使用部分小程序")
object SpoofHostVersion : SwitchHookItem(), IResolvesDex {

    override fun onEnable() {
        methodCgiLaunchWxaAppFunc1122.hookBefore {
            args[6] = 9999
        }
    }

    private val methodCgiLaunchWxaAppFunc1122 by dexMethod()

    override fun resolveDex(dexKit: DexKitBridge) {
        methodCgiLaunchWxaAppFunc1122.find(dexKit) {
            matcher {
                usingEqStrings(
                    "MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122",
                    "<init> cgiHash[%d], username[%s] appId[%s] sync[%b] sessionId[%s] instanceId[%s] libVersion[%d], source:%s, launchMode:%d, migrate:%b, fallback:%b"
                )
            }
        }
    }
}
