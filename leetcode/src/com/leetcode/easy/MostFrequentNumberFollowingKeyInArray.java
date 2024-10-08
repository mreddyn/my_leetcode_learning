package com.leetcode.easy;

public class MostFrequentNumberFollowingKeyInArray {
    public int mostFrequent(int[] nums, int key) {
        /*
         * we will maintain a map which keeps track of target numbers and their
         * frequencies.
         * While iterating(starting from 1) through nums, if we encounter a key then we
         * add target to the
         * map, while also checking if mostFrequentNumber freq is greater than current
         * target frequency.
         * if so we will update mostFrequentNumber.
         */
        int mostFrequentNumber = 0, n = nums.length;
        var freqMap = new int[1001];
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] == key && ++freqMap[nums[i]] > freqMap[mostFrequentNumber]) {
                mostFrequentNumber = nums[i];
            }
        }

        return mostFrequentNumber;
    }

    public static void main(String[] args) {
        var nums = new int[] { 1, 999, 3, 999, 5, 999, 7, 999, 9, 999, 11, 999, 13, 999, 15, 999, 17, 999, 19, 999, 21,
                999, 23, 999, 25, 999, 27, 999, 29, 999, 31, 999, 33, 999, 35, 999, 37, 999, 39, 999, 41, 999, 43, 999,
                45, 999, 47, 999, 49, 999, 51, 999, 53, 999, 55, 999, 57, 999, 59, 999, 61, 999, 63, 999, 65, 999, 67,
                999, 69, 999, 71, 999, 73, 999, 75, 999, 77, 999, 79, 999, 81, 999, 83, 999, 85, 999, 87, 999, 89, 999,
                91, 999, 93, 999, 95, 999, 97, 999, 99, 999, 101, 999, 103, 999, 105, 999, 107, 999, 109, 999, 111, 999,
                113, 999, 115, 999, 117, 999, 119, 999, 121, 999, 123, 999, 125, 999, 127, 999, 129, 999, 131, 999, 133,
                999, 135, 999, 137, 999, 139, 999, 141, 999, 143, 999, 145, 999, 147, 999, 149, 999, 151, 999, 153, 999,
                155, 999, 157, 999, 159, 999, 161, 999, 163, 999, 165, 999, 167, 999, 169, 999, 171, 999, 173, 999, 175,
                999, 177, 999, 179, 999, 181, 999, 183, 999, 185, 999, 187, 999, 189, 999, 191, 999, 193, 999, 195, 999,
                197, 999, 199, 999, 201, 999, 203, 999, 205, 999, 207, 999, 209, 999, 211, 999, 213, 999, 215, 999, 217,
                999, 219, 999, 221, 999, 223, 999, 225, 999, 227, 999, 229, 999, 231, 999, 233, 999, 235, 999, 237, 999,
                239, 999, 241, 999, 243, 999, 245, 999, 247, 999, 249, 999, 251, 999, 253, 999, 255, 999, 257, 999, 259,
                999, 261, 999, 263, 999, 265, 999, 267, 999, 269, 999, 271, 999, 273, 999, 275, 999, 277, 999, 279, 999,
                281, 999, 283, 999, 285, 999, 287, 999, 289, 999, 291, 999, 293, 999, 295, 999, 297, 999, 299, 999, 301,
                999, 303, 999, 305, 999, 307, 999, 309, 999, 311, 999, 313, 999, 315, 999, 317, 999, 319, 999, 321, 999,
                323, 999, 325, 999, 327, 999, 329, 999, 331, 999, 333, 999, 335, 999, 337, 999, 339, 999, 341, 999, 343,
                999, 345, 999, 347, 999, 349, 999, 351, 999, 353, 999, 355, 999, 357, 999, 359, 999, 361, 999, 363, 999,
                365, 999, 367, 999, 369, 999, 371, 999, 373, 999, 375, 999, 377, 999, 379, 999, 381, 999, 383, 999, 385,
                999, 387, 999, 389, 999, 391, 999, 393, 999, 395, 999, 397, 999, 399, 999, 401, 999, 403, 999, 405, 999,
                407, 999, 409, 999, 411, 999, 413, 999, 415, 999, 417, 999, 419, 999, 421, 999, 423, 999, 425, 999, 427,
                999, 429, 999, 431, 999, 433, 999, 435, 999, 437, 999, 439, 999, 441, 999, 443, 999, 445, 999, 447, 999,
                449, 999, 451, 999, 453, 999, 455, 999, 457, 999, 459, 999, 461, 999, 463, 999, 465, 999, 467, 999, 469,
                999, 471, 999, 473, 999, 475, 999, 477, 999, 479, 999, 481, 999, 483, 999, 485, 999, 487, 999, 489, 999,
                491, 999, 493, 999, 495, 999, 497, 999, 499, 999, 501, 999, 503, 999, 505, 999, 507, 999, 509, 999, 511,
                999, 513, 999, 515, 999, 517, 999, 519, 999, 521, 999, 523, 999, 525, 999, 527, 999, 529, 999, 531, 999,
                533, 999, 535, 999, 537, 999, 539, 999, 541, 999, 543, 999, 545, 999, 547, 999, 549, 999, 551, 999, 553,
                999, 555, 999, 557, 999, 559, 999, 561, 999, 563, 999, 565, 999, 567, 999, 569, 999, 571, 999, 573, 999,
                575, 999, 577, 999, 579, 999, 581, 999, 583, 999, 585, 999, 587, 999, 589, 999, 591, 999, 593, 999, 595,
                999, 597, 999, 599, 999, 601, 999, 603, 999, 605, 999, 607, 999, 609, 999, 611, 999, 613, 999, 615, 999,
                617, 999, 619, 999, 621, 999, 623, 999, 625, 999, 627, 999, 629, 999, 631, 999, 633, 999, 635, 999, 637,
                999, 639, 999, 641, 999, 643, 999, 645, 999, 647, 999, 649, 999, 651, 999, 653, 999, 655, 999, 657, 999,
                659, 999, 661, 999, 663, 999, 665, 999, 667, 999, 669, 999, 671, 999, 673, 999, 675, 999, 677, 999, 679,
                999, 681, 999, 683, 999, 685, 999, 687, 999, 689, 999, 691, 999, 693, 999, 695, 999, 697, 999, 699, 999,
                701, 999, 703, 999, 705, 999, 707, 999, 709, 999, 711, 999, 713, 999, 715, 999, 717, 999, 719, 999, 721,
                999, 723, 999, 725, 999, 727, 999, 729, 999, 731, 999, 733, 999, 735, 999, 737, 999, 739, 999, 741, 999,
                743, 999, 745, 999, 747, 999, 749, 999, 751, 999, 753, 999, 755, 999, 757, 999, 759, 999, 761, 999, 763,
                999, 765, 999, 767, 999, 769, 999, 771, 999, 773, 999, 775, 999, 777, 999, 779, 999, 781, 999, 783, 999,
                785, 999, 787, 999, 789, 999, 791, 999, 793, 999, 795, 999, 797, 999, 799, 999, 801, 999, 803, 999, 805,
                999, 807, 999, 809, 999, 811, 999, 813, 999, 815, 999, 817, 999, 819, 999, 821, 999, 823, 999, 825, 999,
                827, 999, 829, 999, 831, 999, 833, 999, 835, 999, 837, 999, 839, 999, 841, 999, 843, 999, 845, 999, 847,
                999, 849, 999, 851, 999, 853, 999, 855, 999, 857, 999, 859, 999, 861, 999, 863, 999, 865, 999, 867, 999,
                869, 999, 871, 999, 873, 999, 875, 999, 877, 999, 879, 999, 881, 999, 883, 999, 885, 999, 887, 999, 889,
                999, 891, 999, 893, 999, 895, 999, 897, 999, 899, 999, 901, 999, 903, 999, 905, 999, 907, 999, 909, 999,
                911, 999, 913, 999, 915, 999, 917, 999, 919, 999, 921, 999, 923, 999, 925, 999, 927, 999, 929, 999, 931,
                999, 933, 999, 935, 999, 937, 999, 939, 999, 941, 999, 943, 999, 945, 999, 947, 999, 949, 999, 951, 999,
                953, 999, 955, 999, 957, 999, 959, 999, 961, 999, 963, 999, 965, 999, 967, 999, 969, 999, 971, 999, 973,
                999, 975, 999, 977, 999, 979, 999, 981, 999, 983, 999, 985, 999, 987, 999, 989, 999, 991, 999, 993, 999,
                995, 999, 997, 999, 999, 999 };
        MostFrequentNumberFollowingKeyInArray mArray = new MostFrequentNumberFollowingKeyInArray();
        System.out.println(mArray.mostFrequent(nums, 999));
    }
}
