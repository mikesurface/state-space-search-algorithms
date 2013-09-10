
package org.harbu.search.problem.constraint;

import org.harbu.search.problem.NoHeuristic;
import org.harbu.search.problem.Problem;

/**
 *
 * @author harbu
 */
public class ConstraintSatisfaction extends Problem<ConstraintSatisfactionState> {
    public ConstraintSatisfaction(ConstraintSatisfactionState startState) {
        setStartState(startState);
        setGoal(new ConstraintSatisfactionGoal());
        setHeuristic(new NoHeuristic<ConstraintSatisfactionState>());
    }
}