import android.app.Application
import com.example.transactionslist.koin.apiModules
import com.example.transactionslist.koin.converterModules
import com.example.transactionslist.koin.networkModules
import com.example.transactionslist.koin.viewModelsModules
import org.koin.core.context.startKoin

class TransactionsListApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(koinContext = this, listOf(viewModelsModules, networkModules, apiModules, converterModules))
    }
}
