package com.example.myfirstproject.model.response

data class LoginResponse(
//    val bankAccounts: List<UserBankAccount>,
    val email: String,
    val firstName: String,
    val authorization:String,
//    val gbpWallet: GBP_Wallet,
    val kyc_level: String,
    val lastName: String,
//    val nairaWallet: NGNWallet?,
    val responsecode: String,
    val responsemessage: String
)