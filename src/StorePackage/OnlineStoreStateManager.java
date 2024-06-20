package StorePackage;

public class OnlineStoreStateManager {
	private OnlineStoreMemento storeMemento;

    public void saveState(OnlineStore store) {
        storeMemento = store.saveStateToMemento();
    }

    public void restoreState(OnlineStore store) {
        if (storeMemento != null) {
            store.restoreStateFromMemento(storeMemento);
        } else {
            System.out.println("No previous state found to restore.");
        }
    }
}
