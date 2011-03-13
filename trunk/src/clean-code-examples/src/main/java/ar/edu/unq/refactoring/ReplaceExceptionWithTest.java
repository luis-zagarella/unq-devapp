package ar.edu.unq.refactoring;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Usar las exceptions solo para excpeciones ;). No para condicionales.
 */
public class ReplaceExceptionWithTest {

    static class ResourcePool_v1 {

        Stack<Resource> available;

        Stack<Resource> allocated;

        Resource getResource() {
            Resource result;
            try {
                result = available.pop();
                allocated.push(result);
                return result;
            } catch (EmptyStackException e) {
                result = new Resource();
                allocated.push(result);
                return result;
            }
        }

    }

    static class ResourcePool_v2 {

        Stack<Resource> available;

        Stack<Resource> allocated;

        Resource getResource() {
            Resource result;
            if (available.isEmpty()) {
                result = new Resource();
            } else {
                result = available.pop();
            }
            allocated.push(result);
            return result;
        }

    }

    static class Resource {

    }

}
