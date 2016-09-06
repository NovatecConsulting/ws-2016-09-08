package example.practice;

import org.apache.commons.lang3.StringUtils;


public class IbanCalculator {

    private static final int CH_ACCOUNT_NUMBER_MAX_LENGTH = 12;
    private static final int AT_ACCOUNT_NUMBER_MAX_LENGTH = 11;
    private static final int DE_ACCOUNT_NUMBER_MAX_LENGTH = 10;

    private static final int AT_BANK_CODE_MIN_LENGTH = 3;
    private static final int AT_BANK_CODE_MAX_LENGTH = 5;
    private static final int CH_BANK_CODE_MIN_LENGTH = 3;
    private static final int CH_BANK_CODE_MAX_LENGTH = 5;
    private static final int DE_BANK_CODE_MIN_LENGTH = 8;
    private static final int DE_BANK_CODE_MAX_LENGTH = DE_BANK_CODE_MIN_LENGTH;

    private Iso7064CodeGenerator iso7064CodeGenerator;

    public IbanCalculator() {
        this.iso7064CodeGenerator = new Iso7064CodeGenerator();
    }

    public String calculate(CountryCode country, String bankCode, String accountNumber) {

        String ibanNumber = null;
        if (country == null) {
            throw new IllegalArgumentException("An invalid country code given");
        }

        if (bankCode == null) {
            throw new IllegalArgumentException("An invalid bank code given");
        }

        if (accountNumber == null || accountNumber.trim().length() == 0) {
            throw new IllegalArgumentException("An invalid account number given");
        }

        if (CountryCode.DE == country) {
            ibanNumber = createIBANForDE(country, bankCode, accountNumber);
        } else if (CountryCode.AT == country) {
            ibanNumber = createIBANForAT(country, bankCode, accountNumber);
        } else {
            ibanNumber = createIBANForCH(country, bankCode, accountNumber);
        }
        return ibanNumber;

    }

    /**
     * Calculates the IBAN for country code 'AT'.
     *
     * @param country The {@link CountryCode}
     * @param bankCode the bank code
     * @param accountNumber the account number
     * @return generated IBAN for 'AT' (including the check code)
     */
    private String createIBANForAT(CountryCode country, String bankCode, String accountNumber) {

        String ibanNumber;

        if (bankCode.trim().length() < AT_BANK_CODE_MIN_LENGTH || bankCode.trim().length() > AT_BANK_CODE_MAX_LENGTH) {
            throw new IllegalArgumentException("An invalid bank code given");
        }

        String paddedBankCode = StringUtils.leftPad(bankCode, AT_BANK_CODE_MAX_LENGTH, '0');
        String paddedAccountNumber = StringUtils.leftPad(accountNumber, AT_ACCOUNT_NUMBER_MAX_LENGTH, '0');

        long checkCode = iso7064CodeGenerator.calculateISO7064CheckCode(country, paddedBankCode, paddedAccountNumber);

        ibanNumber = CountryCode.AT.name() + Long.valueOf(checkCode).toString() + bankCode + paddedAccountNumber;
        return ibanNumber;

    }

    /**
     * Calculates the IBAN for country code 'CH'.
     *
     * @param country The country code
     * @param bankCode the bank code
     * @param accountNumber the account number
     * @return generated IBAN for 'CH' (including the check code)
     */
    private String createIBANForCH(CountryCode country, String bankCode, String accountNumber) {

        String ibanNumber;
        if (bankCode.trim().length() < CH_BANK_CODE_MIN_LENGTH || bankCode.trim().length() > CH_BANK_CODE_MAX_LENGTH) {
            throw new IllegalArgumentException("An invalid bank code given");
        }

        String paddedAccountNumber = StringUtils.leftPad(accountNumber, CH_ACCOUNT_NUMBER_MAX_LENGTH, '0');
        String paddedBankCode = StringUtils.leftPad(bankCode, CH_BANK_CODE_MAX_LENGTH, '0');

        long checkCode = iso7064CodeGenerator.calculateISO7064CheckCode(country, paddedBankCode, paddedAccountNumber);

        ibanNumber = CountryCode.CH.name() + Long.valueOf(checkCode).toString() + paddedBankCode + paddedAccountNumber;
        return ibanNumber;

    }

    /**
     * Calculates the IBAN for country code 'DE'.
     *
     * @param country The {@link CountryCode}
     * @param bankCode the bank code
     * @param accountNumber the account number
     * @return generated IBAN for 'DE' (including the check code)
     */
    private String createIBANForDE(CountryCode country, String bankCode, String accountNumber) {

        String ibanNumber;
        if (bankCode.trim().length() < DE_BANK_CODE_MIN_LENGTH || bankCode.trim().length() > DE_BANK_CODE_MAX_LENGTH) {
            throw new IllegalArgumentException("An invalid bank code given");
        }

        String paddedAccountNumber = StringUtils.leftPad(accountNumber, DE_ACCOUNT_NUMBER_MAX_LENGTH, '0');

        long checkCode = iso7064CodeGenerator.calculateISO7064CheckCode(country, bankCode, paddedAccountNumber);
        String paddedCheckCode = StringUtils.leftPad(String.valueOf(checkCode), 2, '0');

        ibanNumber = CountryCode.DE.name() + paddedCheckCode + bankCode + paddedAccountNumber;
        return ibanNumber;

    }

}
