package com.dezdeqness.domain.usecases

import com.dezdeqness.domain.model.AccountEntity
import com.dezdeqness.domain.repository.AccountRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetProfileUseCase(
    private val accountRepository: AccountRepository,
) {

    operator fun invoke(): Flow<Result<AccountEntity>> = accountRepository.getProfileDetails()

}
