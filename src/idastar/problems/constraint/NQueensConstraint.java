package idastar.problems.constraint;

import java.util.List;
import java.util.Set;

public class NQueensConstraint implements Constraint {

    private int n;

    public NQueensConstraint(int n) {
        super();
        this.n = n;
    }

    @Override
    public void apply(int varIndex, Integer valueChosen, List<Set<Integer>> domains) {
        handleHorizontal(domains, varIndex);
        handleVertical(domains, valueChosen);
        handleDiagonals(varIndex, valueChosen, domains);
    }

    private void handleHorizontal(List<Set<Integer>> domains, int varIndex) {
        domains.get(varIndex).clear();
    }

    private void handleVertical(List<Set<Integer>> domains, Integer valueChosen) {
        for (Set<Integer> domain : domains) {
            domain.remove(valueChosen);
        }
    }

    private void handleDiagonals(int varIndex, Integer valueChosen, List<Set<Integer>> domains) {
        handleUpperLeftDiagonal(varIndex, valueChosen, domains);
        handleLowerRightDiagonal(varIndex, valueChosen, domains);
        handleUpperRightDiagonal(varIndex, valueChosen, domains);
        handleLowerLeftDiagonal(varIndex, valueChosen, domains);
    }

    private void handleUpperLeftDiagonal(int varIndex, Integer valueChosen, List<Set<Integer>> domains) {
        int row = varIndex - 1;
        int col = valueChosen - 1;
        while (col >= 0 && row >= 0) {
            domains.get(row).remove(col);
            --row;
            --col;
        }
    }

    private void handleLowerRightDiagonal(int varIndex, Integer valueChosen, List<Set<Integer>> domains) {
        int row = varIndex + 1;
        int col = valueChosen + 1;
        while (col < n && row < n) {
            domains.get(row).remove(col);
            ++row;
            ++col;
        }
    }

    private void handleUpperRightDiagonal(int varIndex, Integer valueChosen, List<Set<Integer>> domains) {
        int row = varIndex - 1;
        int col = valueChosen + 1;
        while (col < n && row >= 0) {
            domains.get(row).remove(col);
            --row;
            ++col;
        }
    }

    private void handleLowerLeftDiagonal(int varIndex, Integer valueChosen, List<Set<Integer>> domains) {
        int row = varIndex + 1;
        int col = valueChosen - 1;
        while (col >= 0 && row < n) {
            domains.get(row).remove(col);
            ++row;
            --col;
        }
    }
}