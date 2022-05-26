package products;

public class Task extends Product {
    private String time;
    private String remark;

    /**
     * initialize the property
     * @param name
     * @param description
     * @param price
     * @param time when do you want to get the service
     * @param remark other requests
     */
    public Task(String name,String description,double price,String time,String remark)
    {
        super(name, description, price);
        this.time=time;
        this.remark=remark;
    }

    /**
     *  get the time of the service
     * @return time
     */
    public String getTime() { return this.time; }

    /**
     * get other remarks
     * @return remark
     */
    public String getRemark() { return remark; }
}
