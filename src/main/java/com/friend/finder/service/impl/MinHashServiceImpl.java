package com.friend.finder.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import com.friend.finder.service.MinHashService;

public class MinHashServiceImpl<T> implements MinHashService {

	private int hash[];
    private int numHash;
 
    public MinHashServiceImpl(int numHash)
    {
        this.numHash = numHash;
        hash = new int[numHash];
        Random r = new Random(11);
        for (int i = 0; i < numHash; i++)
        {
            int a = (int) r.nextInt();
            int b = (int) r.nextInt();
            int c = (int) r.nextInt();
            int x = hash(a * b * c, a, b, c);
            hash[i] = x;
        }
    }
	public double similarity(Set set1, Set set2) {
        int numSets = 2;
        Map<T, boolean[]> bitMap = buildBitMap(set1, set2);
        int[][] minHashValues = initializeHashBuckets(numSets, numHash);
        computeMinHashForSet(set1, 0, minHashValues, bitMap);
        computeMinHashForSet(set2, 1, minHashValues, bitMap);
        return computeSimilarityFromSignatures(minHashValues, numHash);
	}

	public int[][] initializeHashBuckets(int numSets, int numHashFunctions) {
        int[][] minHashValues = new int[numSets][numHashFunctions];
        for (int i = 0; i < numSets; i++)
        {
            for (int j = 0; j < numHashFunctions; j++)
            {
                minHashValues[i][j] = Integer.MAX_VALUE;
            }
        }
        return minHashValues;
	}

	public double computeSimilarityFromSignatures(int[][] minHashValues, int numHashFunctions) {
		int identicalMinHashes = 0;
        for (int i = 0; i < numHashFunctions; i++)
        {
            if (minHashValues[0][i] == minHashValues[1][i])
            {
                identicalMinHashes++;
            }
        }
        return (1.0 * identicalMinHashes) / numHashFunctions;
	}

	public int hash(int x, int a, int b, int c) {
        int hashValue = (int) ((a * (x >> 4) + b * x + c) & 131071);
        return Math.abs(hashValue);
	}

	public void computeMinHashForSet(Set set, int setIndex, int[][] minHashValues, Map bitArray) {
        int index = 0;
        for (Object element : bitArray.keySet())
        {
            /*
             * for every element in the bit array
             */
            for (int i = 0; i < numHash; i++)
            {
                /*
                 * for every hash
                 */
                if (set.contains(element))
                {
                    /*
                     * if the set contains the element
                     */
                    int hindex = hash[index];
                    if (hindex < minHashValues[setIndex][index])
                    {
                        /*
                         * if current hash is smaller than the existing hash in
                         * the slot then replace with the smaller hash value
                         */
                        minHashValues[setIndex][i] = hindex;
                    }
                }
            }
            index++;
        }
	}

	public Map buildBitMap(Set set1, Set set2) {
		Map<Object, boolean[]> bitArray = new HashMap<Object, boolean[]>();
        for (Object t : set1)
        {
            bitArray.put(t, new boolean[] { true, false });
        }
        for (Object t : set2)
        {
            if (bitArray.containsKey(t))
            {
                // item is not present in set1
                bitArray.put(t, new boolean[] { true, true });
            }
            else if (!bitArray.containsKey(t))
            {
                // item is not present in set1
                bitArray.put(t, new boolean[] { false, true });
            }
        }
        return bitArray;
    }
	

}
