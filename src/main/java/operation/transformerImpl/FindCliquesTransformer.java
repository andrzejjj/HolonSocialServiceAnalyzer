package operation.transformerImpl;

import hssa.dto.MessageHolder;
import operation.Transformer;
import org.jgrapht.DirectedGraph;
import org.jgrapht.EdgeFactory;
import org.jgrapht.Graph;
import org.jgrapht.alg.BronKerboschCliqueFinder;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by lee on 2015-07-07.
 */
public class FindCliquesTransformer implements Transformer {
    @Override
    public List<MessageHolder> transform(List<MessageHolder> results) {
        Set<String> allUsers = new HashSet<>();
        allUsers.addAll(
                results.stream()
                    .map(messageHolder ->
                            messageHolder.getUser())
                    .collect(Collectors.toList())
        );
        allUsers.addAll(
                results.stream()
                        .flatMap(messageHolder ->
                                ((List<String>) messageHolder.getValue()).stream())
                        .collect(Collectors.toList())
        );

        DirectedGraph<String, DefaultEdge> communicationGraph =
                new SimpleDirectedGraph<String, DefaultEdge>(DefaultEdge.class);

        allUsers.stream().forEach(userName -> communicationGraph.addVertex(userName));
        for (MessageHolder result : results) {
            for (String neighbour : (List<String>)result.getValue()) {
                if (!neighbour.equals(result.getUser()))
                    communicationGraph.addEdge(neighbour, result.getUser());
            }
        }

        BronKerboschCliqueFinder<String, DefaultEdge> bronKerboschCliqueFinder =
                new BronKerboschCliqueFinder<String, DefaultEdge>(communicationGraph);

        Collection<Set<String>> allMaximalCliques = bronKerboschCliqueFinder.getAllMaximalCliques();

        List<MessageHolder> output =
                new LinkedList<>();

        int i=0;
        for (Set<String> clique : allMaximalCliques) {
            MessageHolder messageHolder = new MessageHolder();
            messageHolder.setUser(Integer.toString(i));
            messageHolder.setValue(String.join(",", clique) );
            output.add(messageHolder);
            i++;
        }

        return output;
    }
}
