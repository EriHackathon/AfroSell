import { NgModule } from '@angular/core';
import { MatDialogModule, MatInputModule, MatButtonModule, MatSelectModule,
    MatRadioModule, MatCardModule, MatToolbarModule, MatSidenavModule, MatIconModule, MatListModule,
MatDividerModule, MatGridListModule } from '@angular/material';
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
        MatGridListModule
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
        MatListModule]
})
export class MaterialModule {}