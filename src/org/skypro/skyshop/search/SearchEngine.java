package org.skypro.skyshop.search;


import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private List<Searchable> searchableItems;

    public SearchEngine() {
        searchableItems = new ArrayList<>();
    }

    public void addItem(Searchable item) {
        searchableItems.add(item);
    }

    public List<Searchable> search(String searchTerm) {
        List<Searchable> results = new ArrayList<>();
        for (Searchable item : searchableItems) {
            if (item.getSearchTerm().toLowerCase().contains(searchTerm.toLowerCase())) {
                results.add(item);
                if (results.size() >= 5) break; // Ограничиваем до 5 результатов
            }
        }
        return results;
    }
}
