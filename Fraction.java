package prog2.prelimgroup;

class Fraction { // Another class "Fraction"
    private int numerator; //Class 'Fraction' variable
    private int denominator;//Class 'Fraction' variable

    public Fraction() { //Method to declare variables numerator to 0 and denominator to 1
        numerator = 0;
        denominator = 1;
    }

    public Fraction(int num, int den) { // Method with provided values (num) & (den)
        numerator = num; // Setting variable (numerator) to provided value (num)
        if (den != 0) { // To verify if provided value (den) is not equal to 0
            denominator = den; // If verified, It sets the variable (denominator) to provided value (den)
        } else { // If provided value (den) is equal to 0,
            throw new IllegalArgumentException("Denominator cannot be zero."); //It prints an error message
        }
    }//End of Fraction method

    public void setNumerator(int num) { //Method to set the provided value (num).
        numerator = num;// Setting the numerator variable to the provided value (num).
    }

    public int getNumerator() {//Method to get the variable "numerator"
        return numerator; // Returning the variable "numerator"
    }

    public void setDenominator(int den) { //Method to set the provided value (den).
        if (den != 0) { // To verify if the denominator (den) is not zero.
            denominator = den;//If the denominator is not zero, it sets the denominator variable to the provided value (den).
        } else { // If the provided value is == 0,
            System.out.println("Denominator cannot be zero."); //It prints an error message
        }
    }//End of setDenominator method

    public int getDenominator() {//Method to get the variable "denominator"
        return denominator;// Returning the variable "denominator"
    }

    public String toString() { //Method to output fraction in String format
        return getNumerator() + "/" + getDenominator(); // Call and returns getNumerator() and getDenominator() in String format
    }

    public double toDouble() { // Method to convert fraction to decimal
        return (double) numerator / denominator; // It divides the numerator by the denominator and returns the result as a double value.
    }

    private int computeGCD(int a, int b) { //Method to compute the Greatest Common Divisor(GCD) of the fraction
        if (b == 0) {// To check if the value(b) is equal to 0
            return a; // If verified,it means value (a) is the GCD of a&b and it returns
        }
        //If b is not equal to 0
        return computeGCD(b, a % b);
    }

    public Fraction add(Fraction other) {//Fraction Method for Addition
        int commonDenominator = this.denominator * other.denominator;//Multiply the denominator of the current fraction (getDenominator()) and the other fraction (other) to find a common denominator.
        int sumNumerator = this.numerator * other.denominator + other.numerator * this.denominator;//Multiply the numerator of the current fraction by the denominator of the
        // other fraction, add it to the product of the numerator of the other fraction and the denominator of the current fraction.
        Fraction sum = new Fraction(sumNumerator, commonDenominator);//Creating a new Fraction object(sum) using the the sum of numerators and the common denominator.
        sum.reduce();//Call a method reduce()to reduce the fraction to its simplest form.
        return sum;//Return the newly created fraction (sum).
    }

    public Fraction subtract(Fraction other) { //Fraction Method for Subtraction
        int commonDenominator = this.denominator * other.denominator;//Multiply the denominator of the current fraction ( getDenominator()) and the other fraction (other) to find a common denominator.
        int diffNumerator = this.numerator * other.denominator - other.numerator * this.denominator;//Multiply the numerator of the current fraction(this)by the denominator of the
        // other fraction(other), subtract it to the product of the numerator of the other fraction and the denominator of the current fraction.
        Fraction diff = new Fraction(diffNumerator, commonDenominator);//Creating a new Fraction object(diff) using the the difference of numerators and the common denominator.
        diff.reduce();//Call the method reduce() to reduce the fraction to its simplest form.
        return diff; //Return the newly created fraction (diff).
    }

    public Fraction multiplyBy(Fraction other) {//Fraction Method for Multiplication
        int productNumerator = this.numerator * other.numerator; //Multiply the numerator of the current fraction (getNumerator() ) by the numerator of the other fraction (other) to find a product numerator.
        int productDenominator = this.denominator * other.denominator;//Multiply the denominator of the current fraction (this) by the denominator of the other fraction (other) to find a product denominator.
        Fraction product = new Fraction(productNumerator, productDenominator);// Creating new Fraction object (product) representing the product of the two fractions.
        product.reduce(); //Call the method reduce() to reduce the fraction to its simplest form.
        return product;//Return the newly created fraction (product).
    }

    public Fraction divideBy(Fraction other) { //Fraction Method for Division
        if (other.getNumerator() == 0) { //To verify if the numerator of the other fraction  is not zero
            throw new ArithmeticException("Division by zero is not allowed."); // It throws Arithmetic Exception if it is zero.
        }
        int quotientNumerator = this.numerator * other.denominator; //Multiply the numerator of the current fraction (getNumerator()) by the numerator of the other fraction (other) to find quotient numerator.
        int quotientDenominator = this.denominator * other.numerator; //Multiply the denominator of the current fraction (this) by the denominator of the other fraction (other) to find a product denominator.
        Fraction quotient = new Fraction(quotientNumerator, quotientDenominator); //Creating new Fraction object (quotient) representing the quotient of the two fractions.
        quotient.reduce();//Call the method reduce() to reduce the fraction to its simplest form.
        return quotient; //Return the newly created fraction (product).
    }

    public void reduce() { //Method for reducing a fraction
        int gcd = computeGCD(numerator, denominator);//Call the computeGCD() method to find the GCD of the numerator and denominator.
        // Compute the greatest common divisor (GCD) of the current numerator and denominator

        //Divide the numerator and denominator by their GCD
        numerator /= gcd;
        denominator /= gcd;
    }
}
