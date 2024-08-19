class BankAccount
{
    private Integer AccountNumber;
    public void SetAccountNumber(Integer Number) { if(Number>0) this.AccountNumber = Number;}
    public Integer GetAccountNumber() {return this.AccountNumber;}
    private Double Balance;
    public void SetBalance(Double Money){if(Money!=0) this.Balance += Money;}
    public Double GetBalance(){ return this.Balance;}
    private String OwnerName;
    public void SetOwnerName(String Name)
    {
        if(!Name.isEmpty() && !Name.isBlank())
        {
            if (Name.matches("^[a-zA-Z]*$"))
                this.OwnerName=Name;
            else this.OwnerName=null;
        }
        else this.OwnerName = null;
    }
    public String GetOwnerName(){ return this.OwnerName;}

    protected void Deposit(Double Money)
    {
        double balance;
        balance =this.GetBalance();
        if(Money != 0) balance +=Money;
        this.SetBalance(balance);
        System.out.println(this.GetOwnerName()+" Current Money in your Bank Account is :" + this.GetBalance().toString());
    }

    protected void WithDraw(Double Money)
    {
        double balance = this.GetBalance();
        if(Money != 0) balance-=Money;
        this.SetBalance(balance);
        System.out.println();

    }

    BankAccount()
    {
        this.AccountNumber = 123456;
        this.OwnerName = null;
        this.Balance =0.0D;
    }

    BankAccount(Integer AcoountNumber, String OwnerName,Double Balance)
    {
        this.SetBalance(Balance);
        this.SetAccountNumber(AcoountNumber);
        this.SetOwnerName(OwnerName);
    }
}

public class Employee extends BankAccount
{
    private String Name;
    public void SetName(String Name) { if(!Name.isBlank() && !Name.isEmpty())this.Name = Name;}
    public String GetName() {return this.Name;}

    private Integer EmployeeNo;
    public void SetEmployeeNo(Integer No) { if(No>0) this.EmployeeNo = No;}
    public Integer GetEmployeeNo() {return this.EmployeeNo;}

    private Double Salary;
    public void SetSalary(Double Salary){ if(Salary>0.0D) this.Salary = Salary;}
    public Double GetSalary() {return this.Salary;}

    Employee()
    {

        super();
        this.Name = null;
        this.EmployeeNo=0;
        this.Salary=10000.0D;
    }
    Employee(String Name,Integer No, Double Salary)
    {
        this.SetName(Name);
        this.SetEmployeeNo(No);
        this.SetSalary(Salary);
    }

    Employee(String Name,
             Integer EmployeeNo,
             Double MountSalary,
             String BackAccountName,
             Integer BackAccountNumber,
             Double CurrentBankBalance)
    {
        this(Name,EmployeeNo,MountSalary);
        super.SetOwnerName(BackAccountName);
        super.SetAccountNumber(BackAccountNumber);
        super.SetBalance(CurrentBankBalance);

    }

    public Double Raise(Double RaisePercentage)
    {
        return this.GetSalary()+((this.GetSalary()*RaisePercentage)/100);
    }
}
