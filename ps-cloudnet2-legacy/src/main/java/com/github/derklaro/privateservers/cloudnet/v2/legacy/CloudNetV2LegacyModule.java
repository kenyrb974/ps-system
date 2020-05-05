/*
 * MIT License
 *
 * Copyright (c) 2020 Pasqual K. and contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.github.derklaro.privateservers.cloudnet.v2.legacy;

import com.github.derklaro.privateservers.api.Plugin;
import com.github.derklaro.privateservers.api.cloud.CloudSystem;
import com.github.derklaro.privateservers.api.module.annotation.Module;
import com.github.derklaro.privateservers.cloudnet.v2.legacy.cloud.CloudNetV2CloudSystem;
import com.github.derklaro.privateservers.cloudnet.v2.legacy.listeners.CloudServiceListener;
import com.github.derklaro.privateservers.cloudnet.v2.legacy.listeners.CloudServiceStartAwaitListener;
import de.dytanic.cloudnet.bridge.CloudServer;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

@Module(
        id = "com.github.derklaro.privateservers.cloudnet.v2",
        displayName = "CloudNetV2LegacyPrivateServerModule",
        version = "1.1.0",
        description = "Module for private servers cloudnet v2 integration",
        authors = "derklaro"
)
public class CloudNetV2LegacyModule {

    public CloudNetV2LegacyModule(@NotNull Plugin plugin) {
        CloudSystem cloudSystem = new CloudNetV2CloudSystem();

        plugin.getCloudSystemDetector().registerCloudSystem(cloudSystem);

        Bukkit.getPluginManager().registerEvents(new CloudServiceListener(cloudSystem), CloudServer.getInstance().getPlugin());
        Bukkit.getPluginManager().registerEvents(new CloudServiceStartAwaitListener(), CloudServer.getInstance().getPlugin());
    }
}