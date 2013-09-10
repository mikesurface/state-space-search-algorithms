package idastar.problems;

public class NoHeuristic<T extends State<T>> implements Heuristic<T> {

    @Override
    public int calculate(T node) {
        return 0;
    }
}
