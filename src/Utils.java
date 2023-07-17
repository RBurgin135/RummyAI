public class Utils {
    public static double[][] convolveMatrix(int[][] matrix, double[][] kernel) {
        int matrixHeight = matrix.length;
        int matrixWidth = matrix[0].length;
        int kernelHeight = kernel.length;
        int kernelWidth = kernel[0].length;
        int paddingHeight = kernelHeight / 2;
        int paddingWidth = kernelWidth / 2;

        int outputHeight = matrixHeight + 2 * paddingHeight - kernelHeight + 1;
        int outputWidth = matrixWidth + 2 * paddingWidth - kernelWidth + 1;
        double[][] output = new double[outputHeight][outputWidth];

        // Pad the input matrix with zeros
        double[][] paddedMatrix = new double[matrixHeight + 2 * paddingHeight][matrixWidth + 2 * paddingWidth];
        for (int i = 0; i < matrixHeight; i++) {
            System.arraycopy(matrix[i], 0, paddedMatrix[i + paddingHeight], paddingWidth, matrixWidth);
        }

        for (int i = 0; i < outputHeight; i++) {
            for (int j = 0; j < outputWidth; j++) {
                for (int k = 0; k < kernelHeight; k++) {
                    for (int l = 0; l < kernelWidth; l++) {
                        output[i][j] += paddedMatrix[i + k][j + l] * kernel[k][l];
                    }
                }
            }
        }

        return output;
    }

}
