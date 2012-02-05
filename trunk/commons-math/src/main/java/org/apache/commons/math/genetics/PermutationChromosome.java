/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.math.genetics;

import java.util.List;

/**
 * Interface indicating that the chromosome represents a permutation of objects.
 *
 * @param <T>
 *            type of the permuted objects
 * @since 2.0
 * @version $Id: PermutationChromosome.java 1235038 2012-01-23 22:26:37Z tn $
 */
public interface PermutationChromosome<T> {

    /**
     * Permutes the <code>sequence</code> of objects of type T according to the
     * permutation this chromosome represents. For example, if this chromosome
     * represents a permutation (3,0,1,2), and the unpermuted sequence is
     * (a,b,c,d), this yields (d,a,b,c).
     *
     * @param sequence the unpermuted (original) sequence of objects
     * @return permutation of <code>sequence</code> represented by this permutation
     */
    List<T> decode(List<T> sequence);

}
