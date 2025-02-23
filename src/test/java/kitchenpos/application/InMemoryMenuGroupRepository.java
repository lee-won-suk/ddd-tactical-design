package kitchenpos.application;


import kitchenpos.menu.application.port.out.MenuGroupRepository;
import kitchenpos.menu.domain.MenuGroup;

import java.util.*;

public class InMemoryMenuGroupRepository implements MenuGroupRepository {
    private final HashMap<UUID, MenuGroup> menuGroups = new HashMap<>();
    @Override
    public MenuGroup save(MenuGroup menuGroup) {
        menuGroups.put(menuGroup.getId(), menuGroup);
        return menuGroups.get(menuGroup.getId());
    }

    @Override
    public List<MenuGroup> findAll() {
        return new ArrayList<>(menuGroups.values());
    }

    @Override
    public Optional<MenuGroup> findById(UUID menuGroupId) {
        return Optional.ofNullable(menuGroups.get(menuGroupId));
    }
}
