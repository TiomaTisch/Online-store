package org.skypro.skyshop.search;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.skypro.skyshop.exception.BestResultNotFound;

public class SearchEngine {
    private List<Searchable> searchableItems;

    public SearchEngine() {
        searchableItems = new ArrayList<>();
    }

    public void addItem(Searchable item) {
        searchableItems.add(item);
    }

    public Map<String, Searchable> search(String searchTerm) {
        Map<String, Searchable> results = new TreeMap<>();
        for (Searchable item : searchableItems) {
            if (item.getSearchTerm().toLowerCase().contains(searchTerm.toLowerCase())) {
                results.put(item.getName(), item);;
            }
        }
        return results ;
    }
    public List<Searchable> findBestMatch(String search) throws BestResultNotFound {

        Searchable bestMatch = null;
        List<Searchable> match = new ArrayList<>();

        for (Searchable item : searchableItems) {
            int count = countOccurrences(item.getSearchTerm(), search);
            if (count != 0) {
                match.add(item);
                bestMatch = item;
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound("Не найден подходящий объект для поискового запроса: " + search);
        }

        return match;
    }

    private int countOccurrences(String text, String search) {
        int count = 0;
        int index = 0;

        while ((index = text.indexOf(search, index)) != -1) {
            count++;
            index++;
        }

        return count;
    }


}
