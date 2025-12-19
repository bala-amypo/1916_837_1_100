@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Vendor {
    private Long id;
    private String vendorName;
    private String email;
    private String phone;
    private String industry;
    private String address;

    // 4-parameter constructor for VendorController
    public Vendor(String vendorName, String email, String phone, String industry) {
        this.vendorName = vendorName;
        this.email = email;
        this.phone = phone;
        this.industry = industry;
    }
}
