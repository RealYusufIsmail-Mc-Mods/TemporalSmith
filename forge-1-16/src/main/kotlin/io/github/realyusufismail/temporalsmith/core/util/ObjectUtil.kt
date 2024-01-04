/*
 * Copyright 2023 RealYusufIsmail.
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */ 
package io.github.realyusufismail.temporalsmith.core.util

import java.util.function.Supplier
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty
import net.minecraftforge.fml.RegistryObject
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.IForgeRegistryEntry

class ObjectHolderDelegate<V : IForgeRegistryEntry<in V>>(val registryObject: RegistryObject<V>) :
    ReadOnlyProperty<Any?, V>, Supplier<V>, () -> V {
    override fun getValue(thisRef: Any?, property: KProperty<*>): V = registryObject.get()
    override fun invoke(): V = registryObject.get()
    override fun get(): V = registryObject.get()
}

fun <V : IForgeRegistryEntry<V>, T : V> DeferredRegister<V>.registerObject(
    name: String,
    supplier: () -> T,
): ObjectHolderDelegate<T> {
    val registryObject = this.register(name, supplier)

    // note that this anonymous class inherits three types
    return ObjectHolderDelegate(registryObject)
}
