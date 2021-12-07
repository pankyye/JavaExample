//需求：根据不同收入类型，计算出总纳税金额

class Main {
    public  static  void main(String[] args){
        Income[] incomes = new Income[]{
                new Income(3000),
                new Salary(7500),
                new StateCouncilSpecialAllowance(15000)
        };
        System.out.println(totalTax(incomes));
    }

    public static double totalTax(Income... incomes){ //Income后面的三个点是什么意思？
        double total = 0;
        for(Income income: incomes){
            total = total + income.getTax();
        }
        return total;
    }
}

class Income{
    protected double income;

    public Income(double income){
        this.income = income;
    }

    public double getTax(){
        return income * 0.1;
    }
}

class Salary extends Income{
    public Salary(double income){
        super(income);
    }

    @Override
    public double getTax(){
        if(income <= 5000){
            return 0;
        }
        return (income - 5000) * 0.2;
    }
}

class StateCouncilSpecialAllowance extends Income{
    public StateCouncilSpecialAllowance(double income){
        super(income);
    }


    @Override
    public double getTax(){
        return 0;
    }
}

/*
观察totalTax()方法：利用多态，totalTax()方法只需要和Income打交道，它完全不需要知道Salary和StateCouncilSpecialAllowance的存在，
就可以正确计算出总的税。如果我们要新增一种稿费收入，只需要从Income派生，然后正确覆写getTax()方法就可以。把新的类型传入totalTax()，
不需要修改任何代码。
*/
