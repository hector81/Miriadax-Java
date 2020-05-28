package Tema3.Multitarea;

class SumarArray {
    private int suma;
    synchronized int sumarArray(int nums[]) {
        suma = 0;
        for (int i = 0; i < nums.length; i++) {
            suma += nums[i];
            System.out.println("La suma en el for para " + Thread.currentThread().getName() + " es " + suma);
            
            try {
                Thread.sleep(10);
            } catch (InterruptedException exc) {
                System.out.println(exc.getMessage());
            }
        }
        return suma;
    }
}

