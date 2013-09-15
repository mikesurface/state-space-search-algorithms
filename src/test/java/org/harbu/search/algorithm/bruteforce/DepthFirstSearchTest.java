package org.harbu.search.algorithm.bruteforce;

import org.harbu.search.algorithm.Algorithm;
import org.harbu.search.algorithm.Result;
import org.harbu.search.problem.Goal;
import org.harbu.search.problem.explicit.ExplicitGraph;
import org.harbu.search.problem.explicit.ExplicitGraphState;
import org.harbu.search.util.GraphNode;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Eric Andrews
 */
public class DepthFirstSearchTest {

    private GraphNode root;
    private GraphNode c;
    private GraphNode aaaa;

    @Before
    public void setUp() {
        root = new GraphNode("root");

        GraphNode a = new GraphNode("a");
        GraphNode b = new GraphNode("b");
        c = new GraphNode("c");
        root.addChildren(a, b, c);

        GraphNode aa = new GraphNode("aa");
        GraphNode ab = new GraphNode("ab");
        a.addChildren(aa, ab);

        GraphNode ba = new GraphNode("ba");
        GraphNode bb = new GraphNode("bb");
        GraphNode bc = new GraphNode("bc");
        b.addChildren(ba, bb, bc);

        GraphNode ca = new GraphNode("ca");
        c.addChildren(ca);

        GraphNode aaa = new GraphNode("aaa");
        aa.addChildren(aaa);

        GraphNode caa = new GraphNode("caa");
        GraphNode cab = new GraphNode("cab");
        ca.addChildren(caa, cab);

        aaaa = new GraphNode("aaaa");
        aa.addChildren(aaaa);
    }

    @Test
    public void testFindTrivial() {
        Result<ExplicitGraphState> result = runDFSWithGoals(root);

        assertTrue(result.foundSolution());
        assertEquals(new ExplicitGraphState(root), result.getGoalState());
        assertEquals(1, result.getStats().getNodesExpanded());
        assertEquals(0, result.getStats().getNodesGenerated());
    }

    @Test
    public void testFindsDeepGoal() {
        Result<ExplicitGraphState> result = runDFSWithGoals(c, aaaa);

        assertTrue(result.foundSolution());
        assertEquals(new ExplicitGraphState(aaaa), result.getGoalState());
        assertEquals(5, result.getStats().getNodesExpanded());
        assertEquals(7, result.getStats().getNodesGenerated());
    }

    public void testFindC() {
        Result<ExplicitGraphState> result = runDFSWithGoals(c);

        assertTrue(result.foundSolution());
        assertEquals(new ExplicitGraphState(c), result.getGoalState());
        assertEquals(11, result.getStats().getNodesExpanded());
        assertEquals(10, result.getStats().getNodesExpanded());
    }

    private Result<ExplicitGraphState> runDFSWithGoals(GraphNode... goals) {
        ExplicitGraph problem = new ExplicitGraph(root, goals);
        Algorithm<ExplicitGraphState> algorithm = new DepthFirstSearch<>(problem);
        return algorithm.run();
    }
}