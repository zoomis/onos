package org.onlab.graph;

import java.util.Map;
import java.util.Set;

/**
 * Representation of a graph path search algorithm.
 *
 * @param <V> vertex type
 * @param <E> edge type
 */
public interface GraphPathSearch<V extends Vertex, E extends Edge<V>> {

    /**
     * Abstraction of a path search result.
     */
    public interface Result<V extends Vertex, E extends Edge<V>> {

        /**
         * Returns the search source.
         *
         * @return search source
         */
        public V src();

        /**
         * Returns the search destination, if was was given.
         *
         * @return optional search destination
         */
        public V dst();

        /**
         * Returns the set of paths produced as a result of the graph search.
         *
         * @return set of paths
         */
        Set<Path<V, E>> paths();

        /**
         * Returns bindings of each vertex to its parent edges in the path.
         *
         * @return map of vertex to its parent edge bindings
         */
        public Map<V, Set<E>> parents();

        /**
         * Return a bindings of each vertex to its cost in the path.
         *
         * @return map of vertex to path cost bindings
         */
        public Map<V, Double> costs();
    }

    /**
     * Searches the specified graph.
     *
     * @param graph  graph to be searched
     * @param src    optional source vertex
     * @param dst    optional destination vertex; if null paths to all vertex
     *               destinations will be searched
     * @param weight optional edge-weight; if null cost of each edge will be
     *               assumed to be 1.0
     * @return search results
     */
    Result<V, E> search(Graph<V, E> graph, V src, V dst, EdgeWeight<V, E> weight);

}