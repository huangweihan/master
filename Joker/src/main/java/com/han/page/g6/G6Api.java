package com.han.page.g6;

import org.springframework.stereotype.Controller;
import java.util.ArrayList;
import java.util.List;

@Controller
public class G6Api {

    public static void main(String[] args) {
        Item item = new Item();
        item.setId("祖宗");

    }

    static class Item {
        private String id;
        private List<Item> children = new ArrayList<>();

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<Item> getChildren() {
            return children;
        }

        public void setChildren(List<Item> children) {
            this.children = children;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "id='" + id + '\'' +
                    ", children=" + children +
                    '}';
        }
    }
}

