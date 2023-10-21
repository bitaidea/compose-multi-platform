import SwiftUI
import shared

@main
struct iOSApp: App {
 init() {
        HelperKt.doInitKoin(DriverFactory().createDriver())
    }

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
