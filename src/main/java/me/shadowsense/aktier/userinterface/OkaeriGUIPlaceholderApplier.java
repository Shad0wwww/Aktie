package me.shadowsense.aktier.userinterface;


import eu.okaeri.injector.annotation.Inject;
import eu.okaeri.placeholders.Placeholders;
import eu.okaeri.placeholders.context.PlaceholderContext;
import eu.okaeri.placeholders.message.CompiledMessage;
import me.abdiskiosk.guis.placeholder.PlaceholderApplier;
import me.abdiskiosk.guis.state.NamedState;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class OkaeriGUIPlaceholderApplier implements PlaceholderApplier {

    private final Placeholders placeholders;

    public OkaeriGUIPlaceholderApplier(@Inject Placeholders placeholders) {
        this.placeholders = placeholders;
    }

    @Override
    public String replace(String s, Collection<? extends NamedState<?>> collection) {
        PlaceholderContext context = PlaceholderContext.of(placeholders, CompiledMessage.of(s));

        Map<String, Object> placeholders = collection.stream()
                .collect(Collectors.toMap(NamedState::getName, NamedState::get));

        return context.with(placeholders).apply();
    }

}