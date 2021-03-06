package org.harbu.search.problem;

import java.util.Objects;

/**
 * Represents an operation, a valid transformation between two connected nodes
 * in a state-space graph in which we move from one to the other. This
 * operation, or edge in graph terminology, comes with an associated cost.
 *
 * @author Eric Andrews
 * @param <T> the state space type
 */
public class Operation<T extends State<T>> {

    private final T node;
    private final double cost;

    public Operation(T node, double cost) {
        this.node = node;
        this.cost = cost;
    }

    public T getNode() {
        return node;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Operation)) {
            return false;
        } else {
            Operation other = (Operation) obj;
            return this.getNode().equals(other.getNode())
                    && this.getCost() == other.getCost();
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.node);
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.cost) ^ (Double.doubleToLongBits(this.cost) >>> 32));
        return hash;
    }
}
