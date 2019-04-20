import { NgModule } from '@angular/core';
import { MatDialogModule, MatInputModule, MatButtonModule, MatSelectModule,
    MatRadioModule, MatCardModule, MatToolbarModule, MatSidenavModule, MatIconModule, MatListModule,
MatDividerModule, MatGridListModule } from '@angular/material';
import {MatMenuModule} from '@angular/material/menu';
@NgModule({
    imports: [
        MatDialogModule,
        MatInputModule,
        MatButtonModule,
        MatSelectModule,
        MatRadioModule,
        MatCardModule,
        MatToolbarModule,
        MatSidenavModule,
        MatIconModule,
        MatListModule,
        MatDividerModule,
        MatGridListModule,
        MatMenuModule
        ],
    exports: [ MatDialogModule,
        MatInputModule,
        MatButtonModule,
        MatSelectModule,
        MatRadioModule,
        MatCardModule,
        MatToolbarModule,
        MatSidenavModule,
        MatIconModule,
        MatDividerModule,
        MatGridListModule,
        MatListModule,
        MatMenuModule]
})
export class MaterialModule {}