import java.util.Scanner;

/**
 * <p>Програма визначає з заданої кількості N чисел ряду Фібоначчі числа, які є на 1 менші ніж певний квадрат</p>
 * <p>Щоб перевірити перші 20 чисел ряду, треба задати N=20</p>
 * <p>N не більше 47, бо int від (-2^31) до (2^31 - 1) </p>
 */
public class LR1 {
    /**
     * Клас, що представляє числа Фібоначчі з порядковим номером та значенням.
     */
    public static class FibNum {
        private int number;
        private int value;

        /**
         * Конструктор для класу FibNum.
         *
         * @param number Порядковий номер числа Фібоначчі
         * @param value  Значення числа Фібоначчі
         */
        public FibNum(int number, int value) {
            this.number = number;
            this.value = value;
        }

        /**
         * Отримує порядковий номер числа Фібоначчі.
         *
         * @return Порядковий номер числа Фібоначчі
         */
        public int getNumber() {
            return this.number;
        }

        /**
         * Отримує значення числа Фібоначчі.
         *
         * @return Значення числа Фібоначчі
         */
        public int getValue() {
            return this.value;
        }
    }

    /**
     * Зчитує ціле число N з консолі.
     *
     * @return Введене користувачем число N
     */
    public static int input() {
        System.out.print("Input N:");
        Scanner console = new Scanner(System.in);
        return console.nextInt();
    }

    /**
     * Генерує масив чисел Фібоначчі розміром count.
     *
     * @param count Кількість чисел Фібоначчі для генерації
     * @return Масив чисел Фібоначчі
     */
    public static FibNum[] makeFib(int count) {
        FibNum[] array = new FibNum[count];
        array[0] = new FibNum(0, 0);
        array[1] = new FibNum(1, 1);
        for (int i = 2; i < array.length; ++i) {
            array[i] = new FibNum(i, array[i - 1].getValue() + array[i - 2].getValue());
        }
        return array;
    }

    /**
     * Перевіряє, чи є число на 1 менше за квадрат.
     *
     * @param number Число для перевірки
     * @return true, якщо число є на 1 менше за квадрат, в іншому випадку false
     */
    public static boolean isSquareMinOne(int number) {
        return Math.sqrt(number + 1) % 1 == 0;
    }

    /**
     * Головний метод програми.
     *
     * @param args Аргументи командного рядка.
     */
    public static void main(String[] args) {
        int N = input();
        FibNum[] array = makeFib(N);

        System.out.println("Fibonacci Numbers:");
        for (FibNum num : array) {
            System.out.print(num.getValue() + " ");
        }

        System.out.println("\nFrom N Fibonachi numbers this are w^2 - 1:");
        for (int i = 1; i < N; i++) {
            if (isSquareMinOne(array[i].getValue())) {
                System.out.print(array[i].getValue() + " ");
            }
        }
    }
}