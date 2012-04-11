package ar.edu.unq;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ListTest {

    @Test
    public void newListShouldBeEmpty() {
        List<Integer> newList = this.newList();

        assertTrue(newList.isEmpty());
    }

    @Test
    public void addingOneElementToemptyListGrowsSizeToOne() {
        List<Integer> newList = this.newList();
        newList.add(1);

        assertThat(newList.size(), is(1));
    }

    protected List<Integer> newList() {
        return new ArrayList<Integer>();
    }

}
